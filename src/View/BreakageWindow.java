package View;

import Controller.Controller;
import Model.BreakageData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.sql.SQLException;
import java.util.List;

public class BreakageWindow {
    private List<BreakageData> breakages;

    public BreakageWindow(Display display) throws SQLException {
        Controller controller = new Controller();
        Shell shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Breakage window");
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
        tableColumn2.setText("Причина");
        tableColumn3.setText("ФИО");
        tableColumn4.setText("ID оборудования");
        tableColumn5.setText("ID подразделения");
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

        breakages = controller.getBreakages();
        table.removeAll();
        for (BreakageData data: breakages) {
            TableItem tableItem = new TableItem(table, SWT.PUSH);
            tableItem.setText(0, data.getDateBreakage());
            tableItem.setText(1, data.getReason());
            tableItem.setText(2, data.getFio());
            tableItem.setText(3, String.valueOf(data.getIdEquipment()));
            tableItem.setText(4, String.valueOf(data.getIdArea()));
        }



        Group group3 = new Group(shell, SWT.SHADOW_IN);
        group3.setText("Добавление");
        group3.setLayout(new RowLayout(SWT.VERTICAL));

        Label label3= new Label(group3, SWT.NONE);
        label3.setText("Введи дату");
        Text text3 = new Text(group3, SWT.BORDER);
        Label label31 = new Label(group3, SWT.NONE);
        label31.setText("Введи причину");
        Text text31 = new Text(group3, SWT.BORDER);
        Label label32 = new Label(group3, SWT.NONE);
        label32.setText("Введи фио");
        Text text32 = new Text(group3, SWT.BORDER);
        Label label33 = new Label(group3, SWT.NONE);
        label33.setText("Введи ID оборудования");
        Text text33 = new Text(group3, SWT.BORDER);
        Label label34 = new Label(group3, SWT.NONE);
        label34.setText("Введи ID подразделения");
        Text text34 = new Text(group3, SWT.BORDER);
        Button button3 = new Button(group3, SWT.NONE);
        button3.setText("Добавить поломку");

        button3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    controller.addBreakage(text3.getText(), text31.getText(), text32.getText(), Integer.valueOf(text33.getText()), Integer.valueOf(text34.getText()));
                    breakages = controller.getBreakages();
                    table.removeAll();
                    for (BreakageData data: breakages) {
                        TableItem tableItem = new TableItem(table, SWT.PUSH);
                        tableItem.setText(0, data.getDateBreakage());
                        tableItem.setText(1, data.getReason());
                        tableItem.setText(2, data.getFio());
                        tableItem.setText(3, String.valueOf(data.getIdEquipment()));
                        tableItem.setText(4, String.valueOf(data.getIdArea()));
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
