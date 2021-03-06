package jodongari.wow.video.service;

import jodongari.wow.video.dto.SavedFileInfo;
import jodongari.wow.video.dto.request.VideoUploadRequest;
import jodongari.wow.video.script.ScriptManager;
import lombok.extern.slf4j.Slf4j;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFmpegUtils;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class FileStoreService {

    private ScriptManager scriptManager;
    FFmpeg ffmpeg = null;
    FFprobe ffprobe = null;

    public FileStoreService(
            ScriptManager scriptManager, @Value("${server.compression.ffmpeg}") String ffmpegPath,
            @Value("${server.compression.ffprobe}") String ffprobePath) throws IOException {
        this.scriptManager = scriptManager;

        // Mac ver
        ffmpeg = new FFmpeg();
        if (!StringUtils.isEmpty(ffmpegPath))
            ffmpeg = new FFmpeg(ffmpegPath);
        ffprobe = new FFprobe();
        if (!StringUtils.isEmpty(ffprobePath))
            ffprobe = new FFprobe(ffprobePath);

    }

    public enum TypeOfMedia {
        Pictures, Videos
    }

    public static String getHomeDir() {
        return System.getProperty("user.home");
    }

    public double getVideoRunningTime(String location) throws IOException {
        return ffprobe.probe(location).getFormat().duration;
    }

    public SavedFileInfo saveOriginalFile(VideoUploadRequest request, TypeOfMedia type) throws IOException {

        final String videoHash = DigestUtils.md5Hex(request.getVideoName() + System.currentTimeMillis());
        final String extension = FilenameUtils.getExtension(request.getVideo().getOriginalFilename());
        final String fileName = videoHash + "." + extension;

        final String dirPath = getHomeDir() + File.separator +
                LocalDate.now() + File.separator +
                videoHash + File.separator +
                type.toString();

        final String originalFilePath = dirPath + File.separator + "Original";

        File dir = new File(originalFilePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String filePath = originalFilePath + File.separator + fileName;
        Files.write(Paths.get(filePath), request.getVideo().getBytes());

        scriptManager.makeCommand(originalFilePath, videoHash, extension, request.getVideoName());

        return SavedFileInfo.builder()
                .videoHash(videoHash)
                .manifestPath(originalFilePath)
                .runningTime((long) Math.ceil(getVideoRunningTime(filePath)))
                .build();
    }

    public void compressVideo(String fileName, String format) throws IOException {
        String dirPath = getHomeDir() + File.separator +
                TypeOfMedia.Videos + File.separator +
                "compressed" + File.separator +
                LocalDate.now();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        FFmpegProbeResult input = ffprobe.probe(fileName);

        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(input).overrideOutputFiles(true)

                .addOutput(new StringBuilder(dirPath)
                        .append(File.separator).append(UUID.randomUUID()).append(".").append(format).toString())
                .setFormat(format)
                .disableSubtitle()

//                config audio
                .setAudioChannels(1)
                .setAudioCodec("aac")
                .setAudioSampleRate(48_000)
                .setAudioBitRate(32_768)

//                config video
                .setVideoCodec("libx264")
                .setVideoFrameRate(24, 1)
                .setVideoResolution(640, 480)

                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
                .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        executor.createJob(builder, new ProgressListener() {

            final double duration_ns = input.getFormat().duration * TimeUnit.SECONDS.toNanos(1);

            @Override
            public void progress(Progress progress) {
                double percentage = progress.out_time_ns / duration_ns;
                log.info("filename: {} -> {} status: {} time: {} ms",
                        input.getFormat().filename,
                        String.format("[%.0f%%]", (percentage * 100)),
                        progress.status,
                        FFmpegUtils.toTimecode(progress.out_time_ns, TimeUnit.NANOSECONDS)
                );
            }
        }).run();
    }


    public void splitFile(){

    }

    public void saveSplitFile(){

    }

    public void getThumbnailByVideo(String filePath) {

    }

}
