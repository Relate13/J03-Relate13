package example;

import example.classloader.SteganographyClassLoader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class Scene  {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Random random=new Random();
        Line line = new Line(Monster.MAX_NUM);
        for(int i=0;i<Monster.MAX_NUM;++i){
            Monster monster=new Monster(0,i*256/Monster.MAX_NUM,0);
            line.put(monster,random.nextInt(Monster.MAX_NUM));
        }

        SnakeSpirit theSnakeSpirit = SnakeSpirit.getTheSnakeSpirit();

        SteganographyClassLoader loader = new SteganographyClassLoader(
                new URL("https://i0.hdslb.com/bfs/new_dyn/ee646e7a327507acaab49819c88186332877232.png"));
        Class c1 = loader.loadClass("example.SelectionSorter");
        SteganographyClassLoader loader2 = new SteganographyClassLoader(
                new URL("https://i0.hdslb.com/bfs/new_dyn/2a3fd0d26ad19aaf03aa04b76489e0982877232.png"));
        Class c2 = loader2.loadClass("example.QuickSorter");
        SteganographyClassLoader loader3 = new SteganographyClassLoader(
                new URL("https://i0.hdslb.com/bfs/new_dyn/27d3e14ad51da62c0c45b5ebaeaf56242877232.png"));
        Class c3 = loader3.loadClass("example.SelectionSorter");

        Sorter sorter = (Sorter) c1.newInstance();

        theSnakeSpirit.setSorter(sorter);

        String log = theSnakeSpirit.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
