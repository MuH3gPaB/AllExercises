package SberTech;

import java.io.File;
import java.util.ArrayList;

public class FileFinder {
    static File find (File folder, String name){
        if(!folder.isDirectory()) return null;
        File[] subfolders = getSubfolders(folder);
        File[] files = getFiles(folder);

        for(File file : files){
            if(file.getName().equals(name)) return file;
        }

        if(subfolders.length == 0) return null;

        for(File subfolder : subfolders){
            File result = find(subfolder, name);
            if(result != null) return result;
        }
        return null;
    }

    static File[] getSubfolders(File folder){
        ArrayList<File> result = new ArrayList<File>();
        if(folder.listFiles() != null)
            {
                for(File file : folder.listFiles()) {
                    if (file.isDirectory()) result.add(file);
                }
            }
        return result.toArray(new File[result.size()]);
    }

    static File[] getFiles(File folder){
        ArrayList<File> result = new ArrayList<File>();
        if(folder.listFiles() != null)
        {
            for(File file : folder.listFiles()) {
                if (!file.isDirectory()) result.add(file);
            }
        }
        return result.toArray(new File[result.size()]);
    }

    public static void main(String args[]){
        File folder = new File("C:\\");
        String name = "wro4j.wiki";

        File file = find(folder, name);

        System.out.println(file.getAbsolutePath());
    }
}
