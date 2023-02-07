import java.io.*;
import groovy.io.*;

def call(Map config=[:]){
    // def dir = new File("C:\\Users\\s7608130\\.jenkins\\workspace\\HelloPipeline@script\\57a03f96f45f173da943de05ed1d1b4df4abb540f21567d573f3f7e83c84959f\\ConsoleApp1");
    def dir = new File(pwd());
    // dir.eachFileRecurse(FileType.ANY) { file ->
    //     println(file.name + '\t' + file.length());
    // }

    // new File(dir.path + '\\releasenotes.txt').withWriter('utf-8')
    new File(dir.path + '/releasenotes.txt').withWriter('utf-8')
    {
        writer ->
            dir.eachFileRecurse(FileType.ANY) { file ->
                if (file.isDirectory()) {
                    writer.writeLine(file.name + '/');
                }
                else {
                    writer.writeLine(file.name + '\t' + file.length());
                }
            }
    }
}