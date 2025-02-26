class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
 
public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Inicio de sesión");
        Logger logger2 = Logger.getInstance();
        logger2.log("Transacción realizada");
    }
}
