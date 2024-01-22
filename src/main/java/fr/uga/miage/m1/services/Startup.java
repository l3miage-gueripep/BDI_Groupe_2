package fr.uga.miage.m1.services;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import fr.uga.miage.m1.entities.Domaine;
import fr.uga.miage.m1.entities.Festival;
import fr.uga.miage.m1.entities.SousDomaine;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.ApplicationRunner;

@Component
@RequiredArgsConstructor
public class Startup implements ApplicationRunner {
    private final DomaineService domaineService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Application started. Running custom code...");
        FileInputStream file = new FileInputStream(new File("data.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);
        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        data.get(Integer.valueOf(i)).add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        data.get(Integer.valueOf(i)).add(String.valueOf(cell.getNumericCellValue()));
                        break;
                    case BOOLEAN:
                        System.out.println("Boolean");
                        break;
                    case FORMULA:
                        System.out.println("Formula");
                        break;
                    default:
                        data.get(new Integer(i)).add(" ");
                }
            }
            i++;
        }
        // System.out.println(data);
        Object[] entries = data.entrySet().toArray();

        // creation des entités stockant les données
        List<Domaine> domaines = new ArrayList<>();
        List<SousDomaine> sousDomaines = new ArrayList<>();
        List<Festival> festivals = new ArrayList<>();
        for (i = 1; i < entries.length; i++) {
            Domaine newDomaine = new Domaine("hello");
        }
        domaineService.create("Hello");
    }
}
