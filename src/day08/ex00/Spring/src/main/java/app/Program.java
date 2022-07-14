package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import printer.Printer;
import printer.PrinterWithDateTimeImpl;
import printer.PrinterWithPrefixImpl;

public class Program {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer printer = context.getBean("printerWithPrefix", PrinterWithPrefixImpl.class);
        printer.print("Hello!");
    }
}
