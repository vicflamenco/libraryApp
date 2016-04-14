package Modelos;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;

/**
 * The RXTable provides some extensions to the default JTable
 *
 * 1) Select All editing - when a text related cell is placed in editing mode
 *    the text is selected. Controlled by invoking a "setSelectAll..." method.
 *
 * 2) reorderColumns - static convenience method for reodering table columns
 */
public class RXTable extends JTable
{
//
//  Static, convenience methods
//
	/**
	 *  Convenience method to order the table columns of a table. The columns
	 *  are ordered based on the column names specified in the array. If the
	 *  column name is not found then no column is moved. This means you can
	 *  specify a null value to preserve the current order of a given column.
	 *
     *  @param table        the table containing the columns to be sorted
     *  @param columnNames  an array containing the column names in the
     *                      order they should be displayed
	 */
	public static void reorderColumns(JTable table, Object... columnNames)
	{
		TableColumnModel model = table.getColumnModel();

		for (int newIndex = 0; newIndex < columnNames.length; newIndex++)
		{
			try
			{
				Object columnName = columnNames[newIndex];
				int index = model.getColumnIndex(columnName);
				model.moveColumn(index, newIndex);
			}
			catch(IllegalArgumentException e) {
                            System.out.println("Error al reordenar columnas. " + e.getMessage());;
                        }
		}
	}
}  // End of Class RXTable
