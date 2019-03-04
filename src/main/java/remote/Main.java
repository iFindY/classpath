package de.arkadi.remote;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.MalformedURLException;
import java.lang.ClassNotFoundException;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;

import de.arkadi.remote.IPrint;
import de.arkadi.remote.ImplPrint;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/Resource/Print.jar");
            URLClassLoader ucl = new URLClassLoader(new URL[] {url});
            Class clazz = ucl.loadClass("de.arkadi.remote.ImplPrint");
            IPrint print = (IPrint) clazz.newInstance();
            print.print();
        } catch (MalformedURLException |
                     ClassNotFoundException |
                     InstantiationException |
                     IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


// javac -d bin/classes/ -sourcepath src $(find . -name *.java)
// search needed types in src for file compilation found with java extenssion
// jar -cvfe Appication.jar Main $(find . -name *.class)
// create a jar with main class "Main"
// jar -cf lib/Print.jar -C bin/classes/ de/arkadi/ImplPrint.class && cd ../..
// jar -cfe lib/Application.jar  Main -C bin/classes $(find . -name *.class)
// 188 > java -cp lib/Print.jar:lib/Application.jar de.arkadi.Main
// jar -cf lib/Resource.war -C lib/ Print.jar
// jar -cfe lib/Test.jar  Main -C bin/classes .
// jar cvf MyJar.jar *.properties lib/*.jar -C bin .
// jar -cfe lib/Full.jar de.arkadi.Main -C src/main/java/ .
// jar -cf lib/Print.jar -C bin/classes/ de/arkadi/ImplPrint.class
// java -jar Application.jar dann brauchst du die main classe nicht angeben 
// jar -cfe ./lib/LocalApplication.jar de.arkadi.local.Main -C bin/classes/ de/arkadi/local/
// !  jar --create --file classes.jar Foo.class Bar.class == -cf
// jar --create --file foo.jar --main-class com.foo.Main
// jar cfe lib/partial/PartApplication.jar de.arkadi.local.Main -C bin/classes/ de/arkadi/local/Main.class -C bin/classes/ de/arkadi/local/IPrint.class
// java -cp bin/classes/:lib/partial/PartPrint.jar de.arkadi.local.Main

