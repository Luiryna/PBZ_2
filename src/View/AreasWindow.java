package View;

import Controller.Controller;
import Model.Data;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.sql.SQLException;
import java.util.List;

public class AreasWindow {

    private List<Data> areas;

    public AreasWindow(Display display) throws SQLException {
        Controller controller = new Controller();
        Shell shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Search window");
        shell.setSize(620, 800);
        shell.setLayout (new RowLayout());

        Table table = new Table(shell, SWT.NONE);
        RowData layoutTable = new RowData();
        layoutTable.width = 180;
        layoutTable.height = 300;
        table.setLayoutData(layoutTable);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);
        TableColumn tableColumnFirst = new TableColumn(table, SWT.NONE);
        TableColumn tableColumnSecond = new TableColumn(table, SWT.NONE);
        tableColumnFirst.setText("ID");
        tableColumnSecond.setText("Название");
        tableColumnFirst.setWidth(100);
        tableColumnSecond.setWidth(100);
        table.getColumn(0);
        table.getColumn(1);

        areas = controller.getAreas();
        table.removeAll();
        for (Data data: areas) {
            TableItem tableItem = new TableItem(table, SWT.PUSH);
            tableItem.setText(0, String.valueOf(data.getIdArea()));
            tableItem.setText(1, data.getNameArea());
        }

        Group group1 = new Group(shell, SWT.SHADOW_IN);
        group1.setText("Удаление");
        group1.setLayout(new RowLayout(SWT.VERTICAL));

        Text text1 = new Text(group1, SWT.BORDER);
        Button button1 = new Button(group1, SWT.NONE);
        button1.setText("Удоли");

        button1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    controller.deleteArea(Integer.parseInt(text1.getText()));
                    areas = controller.getAreas();
                    table.removeAll();
                    for (Data data: areas) {
                        TableItem tableItem = new TableItem(table, SWT.PUSH);
                        tableItem.setText(0, String.valueOf(data.getIdArea()));
                        tableItem.setText(1, data.getNameArea());
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
        label21.setText("Введи новое название");
        Text text21 = new Text(group2, SWT.BORDER);
        Button button2 = new Button(group2, SWT.NONE);
        button2.setText("Обновить записи");

        button2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    controller.changeArea(Integer.parseInt(text2.getText()), text21.getText());
                    areas = controller.getAreas();
                    table.removeAll();
                    for (Data data: areas) {
                        TableItem tableItem = new TableItem(table, SWT.PUSH);
                        tableItem.setText(0, String.valueOf(data.getIdArea()));
                        tableItem.setText(1, data.getNameArea());
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
        label31.setText("Введи название");
        Text text31 = new Text(group3, SWT.BORDER);
        Button button3 = new Button(group3, SWT.NONE);
        button3.setText("Добавить подразделение");

        button3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    controller.addArea(Integer.parseInt(text3.getText()), text31.getText());
                    areas = controller.getAreas();
                    table.removeAll();
                    for (Data data: areas) {
                        TableItem tableItem = new TableItem(table, SWT.PUSH);
                        tableItem.setText(0, String.valueOf(data.getIdArea()));
                        tableItem.setText(1, data.getNameArea());
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        shell.open();
    }

    private void createColumn(Table table, String text, int width){
        TableColumn fioColumn = new TableColumn(table, SWT.CENTER);
        fioColumn.setText(text);
        fioColumn.setResizable(true);
        fioColumn.setWidth(width);
    }


}
