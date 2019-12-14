package View;

import Controller.Controller;
import Model.EmployeeData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.sql.SQLException;
import java.util.List;

public class EmployeeWindow {
    private List<EmployeeData> areas;

    public EmployeeWindow(Display display) throws SQLException {
        Controller controller = new Controller();
        Shell shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Работники");
        shell.setSize(600, 600);
        shell.setLayout (new RowLayout());

        Table table = new Table(shell, SWT.NONE);
        RowData layoutTable = new RowData();
        layoutTable.width = 600;
        layoutTable.height = 300;
        table.setLayoutData(layoutTable);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);
        TableColumn tableColumnFirst = new TableColumn(table, SWT.NONE);
        TableColumn tableColumnSecond = new TableColumn(table, SWT.NONE);
        TableColumn tableColumnThird = new TableColumn(table, SWT.NONE);
        tableColumnFirst.setText("ID");
        tableColumnSecond.setText("ФИО");
        tableColumnThird.setText("Должность");
        tableColumnFirst.setWidth(200);
        tableColumnSecond.setWidth(200);
        tableColumnThird.setWidth(200);
        table.getColumn(0);
        table.getColumn(1);
        table.getColumn(2);

        areas = controller.getEmployees();
        table.removeAll();
        for (EmployeeData data: areas) {
            TableItem tableItem = new TableItem(table, SWT.PUSH);
            tableItem.setText(0, String.valueOf(data.getIdEmployee()));
            tableItem.setText(1, data.getFio());
            tableItem.setText(2, data.getPosition());
        }

        Group group1 = new Group(shell, SWT.SHADOW_IN);
        group1.setText("Удаление");
        group1.setLayout(new RowLayout(SWT.VERTICAL));

        Text text1 = new Text(group1, SWT.BORDER);
        Button button1 = new Button(group1, SWT.NONE);
        button1.setText("Удаление");

        button1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    controller.deleteEmployee(Integer.parseInt(text1.getText()));
                    areas = controller.getEmployees();
                    table.removeAll();
                    for (EmployeeData data: areas) {
                        TableItem tableItem = new TableItem(table, SWT.PUSH);
                        tableItem.setText(0, String.valueOf(data.getIdEmployee()));
                        tableItem.setText(1, data.getFio());
                        tableItem.setText(2, data.getPosition());
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Group group2 = new Group(shell, SWT.SHADOW_IN);
        group2.setText("Изменение");
        group2.setLayout(new RowLayout(SWT.VERTICAL));

        Label label2 = new Label(group2, SWT.NONE);
        label2.setText("Введи ID");
        Text text2 = new Text(group2, SWT.BORDER);
        Label label21 = new Label(group2, SWT.NONE);
        label21.setText("Введи новое фио");
        Text text21 = new Text(group2, SWT.BORDER);
        Label label22 = new Label(group2, SWT.NONE);
        label22.setText("Введи новую должность");
        Text text22 = new Text(group2, SWT.BORDER);
        Button button2 = new Button(group2, SWT.NONE);
        button2.setText("Обновить записи");

        button2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    controller.changeEmployee(Integer.parseInt(text2.getText()), text21.getText(), text22.getText());
                    areas = controller.getEmployees();
                    table.removeAll();
                    for (EmployeeData data: areas) {
                        TableItem tableItem = new TableItem(table, SWT.PUSH);
                        tableItem.setText(0, String.valueOf(data.getIdEmployee()));
                        tableItem.setText(1, data.getFio());
                        tableItem.setText(2, data.getPosition());
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Group group3 = new Group(shell, SWT.SHADOW_IN);
        group3.setText("Добавление");
        group3.setLayout(new RowLayout(SWT.VERTICAL));

        Label label3= new Label(group3, SWT.NONE);
        label3.setText("Введи ID");
        Text text3 = new Text(group3, SWT.BORDER);
        Label label31 = new Label(group3, SWT.NONE);
        label31.setText("Введи фио");
        Text text31 = new Text(group3, SWT.BORDER);
        Label label32 = new Label(group3, SWT.NONE);
        label32.setText("Введи должность");
        Text text32 = new Text(group3, SWT.BORDER);
        Button button3 = new Button(group3, SWT.NONE);
        button3.setText("Добавить работника");

        button3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    controller.addEmployee(Integer.parseInt(text3.getText()), text31.getText(), text32.getText());
                    areas = controller.getEmployees();
                    table.removeAll();
                    for (EmployeeData data: areas) {
                        TableItem tableItem = new TableItem(table, SWT.PUSH);
                        tableItem.setText(0, String.valueOf(data.getIdEmployee()));
                        tableItem.setText(1, data.getFio());
                        tableItem.setText(2, data.getPosition());
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        shell.open();
    }
}
