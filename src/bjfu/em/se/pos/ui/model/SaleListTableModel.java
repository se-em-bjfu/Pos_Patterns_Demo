package bjfu.em.se.pos.ui.model;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import bjfu.em.se.pos.domain.Sale;

public class SaleListTableModel extends AbstractTableModel {

	private List<Sale> sales;
	private SimpleDateFormat dateFormat;

	public SaleListTableModel(List<Sale> sales) {
		super();
		this.sales = sales;
		dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		if (sales==null)
			return 0;
		return sales.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		Sale sale=sales.get(rowIndex);
		switch(colIndex) {
		case 0:
			return rowIndex+1;
		case 1:
			return dateFormat.format(sale.getDate());
		case 2:
			return String.format("%.2f",(double)sale.getPreDiscountTotal()/100);
		case 3:
			return sale.getPricingStrategy().getName();
		case 4:
			return String.format("%.2f",(double)sale.getTotal()/100);
		case 5:
			return String.format("%.2f",(double)sale.getPayment().getAmount()/100);
		case 6:
			return sale.getPayment().getType();
		case 7:
			return String.format("%.2f",(double)sale.getBalance()/100);
		}
		return "";
	}
	
	@Override
	public String getColumnName(int colIndex) {
		switch(colIndex) {
		case 0:
			return "序号";
		case 1:
			return "时间";
		case 2:
			return "总金额";
		case 3:
			return "折扣类型";
		case 4:
			return "应付金额";			
		case 5:
			return "付款金额";
		case 6:
			return "付款类型";
		case 7:
			return "找零金额";
		}
		return "";
	}
	
	
}
