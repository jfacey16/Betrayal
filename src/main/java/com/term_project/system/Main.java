package com.term_project.system;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        System.out.println("Starting REPL");
        Environment env = new Environment();
        try {
          env.startRepl();
        } catch (Throwable e) {
          e.printStackTrace();
        }
    }
}
