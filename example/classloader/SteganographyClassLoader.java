package example.classloader;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import example.encoder.SteganographyEncoder;

public class SteganographyClassLoader extends ClassLoader {

    private URL url;

    public SteganographyClassLoader(URL imageURL) {
        super();
        this.url = imageURL;
    }

    public SteganographyClassLoader(URL imageURL, ClassLoader parent) {
        super(parent);
        this.url = imageURL;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("Try Find Class:");
        try {
            BufferedImage img = ImageIO.read(url);

            SteganographyEncoder encoder = new SteganographyEncoder(img);
            byte[] bytes = encoder.decodeByteArray();
            return this.defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            throw new ClassNotFoundException();
        }

    }

}
