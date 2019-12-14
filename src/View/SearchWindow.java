package View;

import Controller.Controller;
import Model.BreakageData;
import Model.InspectionData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.sql.SQLException;
import java.util.List;

public class SearchWindow {
    private List<BreakageData> breakages;
    private List<InspectionData> search2;
    private List<InspectionData> search3;

    public SearchWindow(Display display) throws SQLException {
        Controller controller = new Controller();
        Shell shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Search window");
        shell.setSize(500, 700);
        shell.setLayout (new RowLayout());

        Table table = new Table(shell, SWT.NONE);
        RowData layoutTable = new RowData();
        layoutTable.width = 500;
        layoutTable.height = 150;
        table.setLayoutData(layoutTable);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);
        TableColumn tableColumn1 = new TableColumn(table, SWT.NONE);
        TableColumn tableColumn2 = new TableColumn(table, SWT.NONE);
        TableColumn tableColumn3 = new TableColumn(table, SWT.NONE);
        TableColumn tableColumn4 = new TableColumn(table, SWT.NONE);
        TableColumn tableColumn5 = new TableColumn(table, SWT.NONE);
        tableColumn1.setText("Причина");
        tableColumn2.setText("Дата");
        tableColumn3.setText("Название об.");
        tableColumn4.setText("Тип об.");
        tableColumn5.setText("Назв. подразделения");
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

        Label label1 = new Label(shell, SWT.NONE);
        label1.setText("Введите дату поломки");
        Text text1 = new Text(shell, SWT.BORDER);
        Button button1 = new Button(shell, SWT.None);
        button1.setText("Поиск 1");
        button1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    breakages = controller.search1(text1.getText());
                    table.removeAll();
                    for (BreakageData data: breakages) {
                        TableItem tableItem = new TableItem(table, SWT.PUSH);
                        tableItem.setText(0, data.getReason());
                        tableItem.setText(1, data.getDateBreakage());
                        tableItem.setText(2, data.getNameEquipment());
                        tableItem.setText(3, data.getTypeEquipment());
                        tableItem.setText(4, data.getNameArea());
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Table table2 = new Table(shell, SWT.NONE);
        RowData layoutTable2 = new RowData();
        layoutTable2.width = 500;
        layoutTable2.height = 150;
        table2.setLayoutData(layoutTable2);
        table2.setLinesVisible(true);
        table2.setHeaderVisible(true);
        TableColumn tableColumn12 = new TableColumn(table2, SWT.NONE);
        TableColumn tableColumn22 = new TableColumn(table2, SWT.NONE);
        TableColumn tableColumn32 = new TableColumn(table2, SWT.NONE);
        TableColumn tableColumn42 = new TableColumn(table2, SWT.NONE);
        TableColumn tableColumn52 = new TableColumn(table2, SWT.NONE);
        tableColumn12.setText("Дата");
        tableColumn22.setText("ID об.");
        tableColumn32.setText("Название об.");
        tableColumn42.setText("Тип об.");
        tableColumn52.setText("Результат");
        tableColumn12.setWidth(100);
        tableColumn22.setWidth(100);
        tableColumn32.setWidth(100);
        tableColumn42.setWidth(100);
        tableColumn52.setWidth(100);
        table2.getColumn(0);
        table2.getColumn(1);
        table2.getColumn(2);
        table2.getColumn(3);
        table2.getColumn(4);

        Label label2 = new Label(shell, SWT.NONE);
        label2.setText("Введите инв. номер");
        Text text2 = new Text(shell, SWT.BORDER);
        Button button2 = new Button(shell, SWT.None);
        button2.setText("Поиск 2");
        button2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    search2 = controller.search2(Integer.parseInt(text2.getText()));
                    table.removeAll();
                    for (InspectionData data: search2) {
                        TableItem tableItem = new TableItem(table2, SWT.PUSH);
                        tableItem.setText(0, data.getDateInspection());
                        tableItem.setText(1, String.valueOf(data.getIdEquipment()));
                        tableItem.setText(2, data.getNameEquipment());
                        tableItem.setText(3, data.getTypeEquipment());
                        tableItem.setText(4, data.getResult());
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Table table3 = new Table(shell, SWT.NONE);
        RowData layoutTable3 = new RowData();
        layoutTable3.width = 500;
        layoutTable3.height = 150;
        table3.setLayoutData(layoutTable3);
        table3.setLinesVisible(true);
        table3.setHeaderVisible(true);
        TableColumn tableColumn13 = new TableColumn(table3, SWT.NONE);
        TableColumn tableColumn23 = new TableColumn(table3, SWT.NONE);
        TableColumn tableColumn33 = new TableColumn(table3, SWT.NONE);
        tableColumn13.setText("ФИО");
        tableColumn23.setText("Должность");
        tableColumn33.setText("Дата");
        tableColumn13.setWidth(100);
        tableColumn23.setWidth(100);
        tableColumn33.setWidth(100);
        table3.getColumn(0);
        table3.getColumn(1);
        table3.getColumn(2);

        Label label3 = new Label(shell, SWT.NONE);
        label3.setText("Введите дату");
        Text text3 = new Text(shell, SWT.BORDER);
        Button button3 = new Button(shell, SWT.None);
        button3.setText("Поиск 3");
        button3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    search3 = controller.search3(text3.getText());
                    table.removeAll();
                    for (InspectionData data: search3) {
                        TableItem tableItem = new TableItem(table3, SWT.PUSH);
                        tableItem.setText(0, data.getFIO());
                        tableItem.setText(1, data.getPosition());
                        tableItem.setText(2, data.getDateInspection());
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        shell.open();
    }
}
