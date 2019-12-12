package View;

import Controller.Controller;
import Model.Data;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.sql.SQLException;
import java.util.List;

public class MainWindow {
    private Display display = new Display();
    private Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
    private List<Data> areas;
    private Controller controller;

    public MainWindow() throws SQLException {
        shell.setText("PBZ 2");
        shell.setSize(500, 500);

       shell.setLayout (new RowLayout());


        Button button1 = new Button(shell, SWT.NONE);
        button1.setText("Просмотр данных о произв. участках");
        button1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    AreasWindow areasWindow = new AreasWindow(display);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button button2 = new Button(shell, SWT.NONE);
        button2.setText("Неожиданная поломка");
        button2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    BreakageWindow breakageWindow = new BreakageWindow(display);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        shell.open();
        while (!shell.isDisposed()){
            if (!display.readAndDispatch()){
                display.sleep();
            }
        }
        display.dispose();
    }
}
