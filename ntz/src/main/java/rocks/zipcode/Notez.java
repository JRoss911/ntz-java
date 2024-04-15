package rocks.zipcode;

import java.util.Map;

/**
 * ntz main command.
 */
public final class Notez extends FileMap implements Map<String, NoteList> {

    private FileMap fileMap;

    public Notez() {
        this.fileMap  = new FileMap();
    }
    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        boolean _debug = true;
        // for help in handling the command line flags and data!
        if (_debug) {
            System.err.print("Argv: [");
            for (String a : args) {
                System.err.print(a+" ");
            }
            System.err.println("]");
        }

        Notez ntzEngine = new Notez();

        ntzEngine.loadDatabase();

        /*
         * You will spend a lot of time right here.
         *
         * instead of loadDemoEntries, you will implement a series
         * of method calls that manipulate the Notez engine.
         * See the first one:
         */
        ntzEngine.loadDemoEntries();

        ntzEngine.saveDatabase();

        if (args.length == 0) { // there are no commandline arguments
            //just print the contents of the filemap.
            ntzEngine.printResults();
        } else {
            if (args[0].equals("-r")) {
                ntzEngine.addToCategory("General", args);
            } // this should give you an idea about how to TEST the Notez engine
              // without having to spend lots of time messing with command line arguments.
        }
        /*
         * what other method calls do you need here to implement the other commands??
         */

    }
// Implementations for addToCategory, saveDatabase, loadDatabase, and potentially others
    // ...

    public void addToCategory(String string, String[] argv) {
    }

    public void saveDatabase() {
        fileMap.save();
    }

    public void loadDatabase() {
        fileMap.load();
        System.out.println("Database loaded!");
    }

    public void printResults() {
        System.out.println(this.fileMap.toString());
    }

    public void loadDemoEntries() {
        fileMap.put("General", new NoteList("The Very first Note"));
        fileMap.put("note2", new NoteList("A secret second note"));
        fileMap.put("category3", new NoteList("Did you buy bread AND eggs?"));
        fileMap.put("anotherNote", new NoteList("Hello from ZipCode!"));
    }
    /*
     * Put all your additional methods that implement commands like forget here...
     */

}
