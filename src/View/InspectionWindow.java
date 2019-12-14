package View;

import Controller.Controller;
import Model.InspectionData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.sql.SQLException;
import java.util.List;

public class InspectionWindow {
    private List<InspectionData> breakages;

    public InspectionWindow(Display display) throws SQLException {
        Controller controller = new Controller();
        Shell shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Inspection window");
        shell.setSize(500, 800);
        shell.setLayout (new RowLayout());

        Table table = new Table(shell, SWT.NONE);
        RowData layoutTable = new RowData();
        layoutTable.width = 500;
        layoutTable.height = 300;
        table.setLayoutData(layoutTable);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);
        TableColumn tableColumn1 = new TableColumn(table, SWT.NONE);
        TableColumn tableColumn2 = new TableColumn(table, SWT.NONE);
        TableColumn tableColumn3 = new TableColumn(table, SWT.NONE);
        TableColumn tableColumn4 = new TableColumn(table, SWT.NONE);
        TableColumn tableColumn5 = new TableColumn(table, SWT.NONE);
        tableColumn1.setText("Дата");
        tableColumn2.setText("Результат");
        tableColumn3.setText("Причина");
        tableColumn4.setText("ID сотрудника");
        tableColumn5.setText("ID оборудования");
        tableColumn1.setWidth(100);
        tableColumn2.setWidth(100);
        tableColumn3.setWidth(100);
        tableColumn4.setWidth(100);
        tableColumn5.setWidth(100);
        table.getColumn(0);
        table.getColumn(1);
        table.getColumn(2);
        table.getColumn(3);
        table.getColumn(4);

        breakages = controller.getInspections();
        table.removeAll();
        for (InspectionData data: breakages) {
            TableItem tableItem = new TableItem(table, SWT.PUSH);
            tableItem.setText(0, data.getDateInspection());
            tableItem.setText(1, data.getResult());
            tableItem.setText(2, data.getReason());
            tableItem.setText(3, String.valueOf(data.getIdEmployee()));
            tableItem.setText(4, String.valueOf(data.getIdEquipment()));
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
                    controller.deleteInspections(text1.getText());
                    breakages = controller.getInspections();
                    table.removeAll();
                    for (InspectionData data: breakages) {
                        TableItem tableItem = new TableItem(table, SWT.PUSH);
                        tableItem.setText(0, data.getDateInspection());
                        tableItem.setText(1, data.getResult());
                        tableItem.setText(2, data.getReason());
                        tableItem.setText(3, String.valueOf(data.getIdEmployee()));
                        tableItem.setText(4, String.valueOf(data.getIdEquipment()));
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
        label2.setText("Введи результат");
        Text text2 = new Text(group2, SWT.BORDER);
        Label label21 = new Label(group2, SWT.NONE);
        label21.setText("Введи новую причину");
        Text text21 = new Text(group2, SWT.BORDER);
        Button button2 = new Button(group2, SWT.NONE);
        button2.setText("Обновить записи");

        button2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    controller.changeInspection(text2.getText(), text21.getText());
                    breakages = controller.getInspections();
                    table.removeAll();
                    for (InspectionData data: breakages) {
                        TableItem tableItem = new TableItem(table, SWT.PUSH);
                        tableItem.setText(0, data.getDateInspection());
                        tableItem.setText(1, data.getResult());
                        tableItem.setText(2, data.getReason());
                        tableItem.setText(3, String.valueOf(data.getIdEmployee()));
                        tableItem.setText(4, String.valueOf(data.getIdEquipment()));
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
        label3.setText("Введи дату");
        Text text3 = new Text(group3, SWT.BORDER);
        Label label31 = new Label(group3, SWT.NONE);
        label31.setText("Введи результат");
        Text text31 = new Text(group3, SWT.BORDER);
        Label label32 = new Label(group3, SWT.NONE);
        label32.setText("Введи причину");
        Text text32 = new Text(group3, SWT.BORDER);
        Label label33 = new Label(group3, SWT.NONE);
        label33.setText("Введи ID работника");
        Text text33 = new Text(group3, SWT.BORDER);
        Label label34 = new Label(group3, SWT.NONE);
        label34.setText("Введи ID оборудования");
        Text text34 = new Text(group3, SWT.BORDER);
        Button button3 = new Button(group3, SWT.NONE);
        button3.setText("Добавить осмотр");

        button3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    controller.addInspection(text3.getText(), text31.getText(), text32.getText(), Integer.valueOf(text33.getText()), Integer.valueOf(text34.getText()));
                    breakages = controller.getInspections();
                    table.removeAll();
                    for (InspectionData data: breakages) {
                        TableItem tableItem = new TableItem(table, SWT.PUSH);
                        tableItem.setText(0, data.getDateInspection());
                        tableItem.setText(1, data.getResult());
                        tableItem.setText(2, data.getReason());
                        tableItem.setText(3, String.valueOf(data.getIdEmployee()));
                        tableItem.setText(4, String.valueOf(data.getIdEquipment()));
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        shell.open();
    }
}
