package generator;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class VelocityGenerator {

    static String inputTemplate = "src/main/java/template/hello_world_example.vm";
    static String className = "VelocityExample";
    static String message = "Hello Velocity";
    static String packageName = "generated";
    static String outputFile = "src/main/java/" + packageName + "/" + className + ".java";

    public static void main(String[] args) throws IOException {
        VelocityEngine engine = new VelocityEngine();
        engine.init();

        VelocityContext context = new VelocityContext();
        context.put("packageName", packageName);
        context.put("className", className);
        context.put("message", message);

        Writer writer = new FileWriter(outputFile);
        Velocity.mergeTemplate(inputTemplate, "UTF-8", context, writer);
        writer.flush();
        writer.close();

        System.out.println("Generated " + outputFile);
    }

}
