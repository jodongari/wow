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
                System.out.println("script : " + line);
            }
            log.info("video script success " +  " originFileName : " + originFileName + " , Hash : " + videoHash);
        } catch (IOException e){
            log.error("###ERROR###" + " originFileName : " + originFileName + " , Hash : " + videoHash);
        } catch (InterruptedException e){
            log.error("###ERROR###" + " originFileName : " + originFileName + " , Hash : " + videoHash);
        }
    }

    public void makeCommand(String path, String videoHash, String extension, String originFileName){
        // $1 path
        // $2 fileName
        // $3 original extension
        runScript(new ArrayList<>(Arrays.asList("./runScript.sh", path, videoHash, extension)), originFileName, videoHash);
    }

}

