package View;

import Controller.Controller;
import Model.ProdAreaData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Image;

import java.sql.SQLException;
import java.util.List;

public class MainWindow {
    private Display display = new Display();
    private Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
    private List<ProdAreaData> areas;
    private Controller controller;

    public MainWindow() throws SQLException {
        shell.setText("PBZ 2");
        shell.setSize(950, 200);
        shell.setBackgroundImage(new Image(display, "img/pic.jpg"));

        RowLayout rowLayout = new RowLayout();
        rowLayout.spacing = 10;
        rowLayout.marginLeft = 50;
        rowLayout.marginTop = 50;
        shell.setLayout(rowLayout);


        Button button1 = new Button(shell, SWT.NONE);
        button1.setBounds(100, 300, 90, 30);
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

        Button equipment = new Button(shell, SWT.NONE);
        equipment.setBounds(200, 400, 90, 30);
        equipment.setText("Оборудование");
        equipment.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    EquipmentWindow equipmentWindow = new EquipmentWindow(display);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button employee = new Button(shell, SWT.NONE);
        employee.setBounds(300, 500, 90, 30);
        employee.setText("Работники");
        employee.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    EmployeeWindow employeeWindow = new EmployeeWindow(display);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button inspection = new Button(shell, SWT.NONE);
        inspection.setBounds(400, 600, 90, 30);
        inspection.setText("Плановый осмотр");

        Button button2 = new Button(shell, SWT.NONE);
        button2.setBounds(500, 700, 90, 30);
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
