package jodongari.wow.video.script;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScriptManager {

    public void runScript(List<String> cmdList, String originFileName, String videoHash){
        Process p;
        try{
            ProcessBuilder pb = new ProcessBuilder(cmdList);
            p = pb.start();
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            log.info("video script success " +  " originFileName : " + originFileName + " , Hash : " + videoHash);
        } catch (IOException e){
            log.error("###ERROR###" + " originFileName : " + originFileName + " , Hash : " + videoHash);
        } catch (InterruptedException e){
            log.error("###ERROR###" + " originFileName : " + originFileName + " , Hash : " + videoHash);
        }
    }

    // 1 path ~/path
    // 2 fileName.extension
    // 3 fileName-720.extension
    public void makeCommand(String path, String videoHash, String extension, String originFileName){
        runScript(new ArrayList<>(Arrays.asList("./runScript.sh", path, videoHash+"."+extension, videoHash+"-720."+extension)), originFileName, videoHash);

        //runScript(new ArrayList<String>(Arrays.asList("ffmpeg", "-y", "-i", "movie.mp4", "-an", "-c:v:", "libx264", "-x264opts", "'keyint=24:min-keyint=24:no-scenecut'", "-b:v 1500k", "-maxrate", "1500k", "-bufsize", "3000k", "-vf", "\"scale=-2:720\"", "movie-720.mp4")));
        //runScript("ffmpeg -y -i movie.mp4 -an -c:v libx264 -x264opts 'keyint=24:min-keyint=24:no-scenecut' -b:v 1500k -maxrate 1500k -bufsize 3000k -vf \"scale=-2:720\" movie-720.mp4");

        // runScript("ffmpeg -y -i movie.mp4 -an -c:v libx264 -x264opts 'keyint=24:min-keyint=24:no-scenecut' -b:v 800k -maxrate 800k -bufsize 1600k -vf \"scale=-2:480\" movie-480.mp4");

        // runScript("ffmpeg -y -i movie.mp4 -an -c:v libx264 -x264opts 'keyint=24:min-keyint=24:no-scenecut' -b:v 400k -maxrate 400k -bufsize 800k -vf \"scale=-2:360\" movie-360.mp4");

        // runScript("ffmpeg -y -i movie.mp4 -vn -c:a aac -b:a 128k movie.m4a");

        // runScript("mp4box -dash 2000 -profile onDemand -out mpd2\\dash.mpd movie-720.mp4 movie-480.mp4 movie-360.mp4 movie.m4a");
    }

}

