package worksheets;

class MalformedURLException extends IOException {  }
class IOException extends Exception {  }

public class Worksheet5 {
    public static void main(String[] args) {

        try {
// code that could throw either a BadException
// or a MyException
            throw new IOException();
        } catch (MalformedURLException be) {
            System.err.println("Bad Exception caught");
        }
        catch (IOException me) {
            System.err.println("My Exception caught");
        }
        catch(Exception e){
            System.err.println("Exception caught.");
        }

        catch(Throwable t){
            System.err.println("Throwable caught.");
        }
    }
}