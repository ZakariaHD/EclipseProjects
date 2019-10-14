import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ExcelSheet {

	// le chemin de votre fichier
	private static final String FILE_NAME = "C:\\Users\\zhaddada\\Desktop\\ReadFileExcel.xlsx";

	// la methode avec str est le mot rechercher
	public static String ChercherValeur(String str,String sht) {
		String result = "null";
		try {

			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);

			// le nom de votre feuille
			Sheet datatypeSheet = workbook.getSheet(sht);

			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();
					if (currentCell.getCellTypeEnum() == CellType.STRING) {
						if (currentCell.getStringCellValue().equalsIgnoreCase(str)) {

							// passer d'une colonne a un autre
							currentCell = cellIterator.next();
							currentCell = cellIterator.next();
							currentCell = cellIterator.next();

							// recuperer le resultat
							result = currentCell.getStringCellValue();
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;

	}

}
