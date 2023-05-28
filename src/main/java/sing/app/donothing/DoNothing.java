package sing.app.donothing;

public class DoNothing {
    public static void main(String[] args) {
        DoNothing app = new DoNothing();
        app.run(args);
    }

    Parameters parameters;

    private void run(String[] args) {
        parameters = new Parameters();
        parameters.process(args);
        if (parameters.help) {
            Version.printHelp(parameters);
        }else if(parameters.version){
            Version.printVersion();
        }
    }
}
