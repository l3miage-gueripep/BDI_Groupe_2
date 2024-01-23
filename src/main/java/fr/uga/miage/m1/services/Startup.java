package fr.uga.miage.m1.services;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import fr.uga.miage.m1.entities.Commune;
import fr.uga.miage.m1.entities.Domaine;
import fr.uga.miage.m1.entities.Festival;
import fr.uga.miage.m1.entities.LieuCovoiturage;
import fr.uga.miage.m1.entities.Region;
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
        List<Domaine> domaines = new ArrayList<>();
        List<SousDomaine> sousDomaines = new ArrayList<>();
        List<Commune> communes = new ArrayList<>();
        List<Festival> festivals = new ArrayList<>();
        List<LieuCovoiturage> lieuxCovoiturages = new ArrayList<>();
        List<Region> regions = new ArrayList<>();


        FileInputStream file = new FileInputStream(new File("data.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);

        Sheet festivalsSheet = workbook.getSheetAt(0);
        Sheet lieuxCovoituragesSheet = workbook.getSheetAt(1);
        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : festivalsSheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING: 
                        String value = cell.getStringCellValue();
                        data.get(Integer.valueOf(i)).add(value); 
                        break;
                    case NUMERIC: data.get(Integer.valueOf(i)).add(String.valueOf(cell.getNumericCellValue())); break;
                    case BOOLEAN: System.out.println("Boolean"); break;
                    case FORMULA: data.get(Integer.valueOf(i)).add(cell.getCellFormula()); break;
                    default: data.get(Integer.valueOf(i)).add(" ");
                }
            }
            i++;
        }
        // System.out.println(data);
        Object[] entries = data.entrySet().toArray();

        // creation des entités stockant les données

        Random rand = new Random();
        for (i = 1; i < entries.length; i++) {

            Object nodeObject = entries[i];
            // System.out.println(node);
            List<String> node = ((Entry<Integer, List<String>>) nodeObject).getValue();
            int j = 0;
            String nomFestival = node.get(j++);
            if(nomFestival != " "){
                String nomRegion = node.get(j++);
                String nomDomaine = node.get(j++);
                String nomSousDomaine = node.get(j++);
                int numDepartement = (int) Double.parseDouble(node.get(j++));
                j++;           
                String siteWeb = node.get(j++);
                String nomLieu = node.get(j++);
                String codePostal = node.get(j++);
                String codeInsee = node.get(j++);
                double longitude;
                double latitude;
                try {
                    longitude = Double.parseDouble(node.get(j));
                    latitude = Double.parseDouble(node.get(j + 1));
                    j+=2;
                } catch (Exception e) {
                    longitude = 0;
                    latitude = 0;
                }
    
    
                String nomDepartement = node.get(j++);
                j++;
                Date dateDebut = DateUtil.getJavaDate(Double.parseDouble(node.get(j++)));
                Date dateFin = dateFin = DateUtil.getJavaDate(Double.parseDouble(node.get(j++)));
                
                double tarifPass = rand.nextInt(78) + 8;
                
                //creation des domaines et sous domaines
                Domaine newDomaine = new Domaine(nomDomaine);
                domaines.add(newDomaine);

                Commune commune = Commune.builder().codeInsee(codeInsee).latitude(latitude).longitude(longitude).build();
                communes.add(commune);
                sousDomaines.add(new SousDomaine(nomSousDomaine, newDomaine));
                Festival festival = Festival.builder()
                    .nomManifestation(nomFestival)
                    .siteWeb(siteWeb)
                    .lieuPrincipal(nomLieu)
                    .dateDebut(dateDebut)
                    .dateFin(dateFin)
                    .tarifPass(tarifPass)
                    .build();
                festivals.add(festival);
            }


            Map<Integer, List<String>> lieuxCovoituragesData = new HashMap<>();
            int k = 0;
            for (Row row : lieuxCovoituragesSheet) {
                lieuxCovoituragesData.put(k, new ArrayList<String>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING: 
                            String value = cell.getStringCellValue();
                            lieuxCovoituragesData.get(Integer.valueOf(k)).add(value); 
                            if(cell.getStringCellValue().contains("Festival de musique de Maguelone")){
                                System.out.println("FESTIVAL DE MUSIQUE DE COMPANS");
                            }
                            break;
                        case NUMERIC: lieuxCovoituragesData.get(Integer.valueOf(k)).add(String.valueOf(cell.getNumericCellValue())); break;
                        case BOOLEAN: System.out.println("Boolean"); break;
                        case FORMULA: lieuxCovoituragesData.get(Integer.valueOf(k)).add(cell.getCellFormula()); break;
                        default: lieuxCovoituragesData.get(Integer.valueOf(k)).add(" ");
                    }
                }
                k++;
            }
            Object[] lieuxCovoituragesEntries = lieuxCovoituragesData.entrySet().toArray();
            System.out.println();
            i = 0;
            for (i = 1; i < lieuxCovoituragesEntries.length; i++) {

                Object lieuxCovoituragesNodeObject = lieuxCovoituragesEntries[i];
                List<String> lieuxCovoituragesNode = ((Entry<Integer, List<String>>) lieuxCovoituragesNodeObject).getValue();
                String idLieu = lieuxCovoituragesNode.get(0);
                if(idLieu.contains("Total")){
                    break;
                }
                String nomLieu = lieuxCovoituragesNode.get(1);
                String adresseLieu = lieuxCovoituragesNode.get(2);
                String communeLieu = lieuxCovoituragesNode.get(3);
                String codeInsee = lieuxCovoituragesNode.get(4);
                String typeLieu = lieuxCovoituragesNode.get(5);
                double longitude = Double.parseDouble(lieuxCovoituragesNode.get(6));
                double latitude = Double.parseDouble(lieuxCovoituragesNode.get(7));

                //trouve la commune avec le code insee
                Commune commune = null;
                for(Commune c : communes){
                    if(c.getCodeInsee().equals(codeInsee)){
                        commune = c;
                        break;
                    }
                }
                commune.setNomCommune(communeLieu);

                Festival festival = null;
                for(Festival f : festivals){
                    if(f.getNomManifestation().equals(nomFestival)){
                        festival = f;
                        break;
                    }
                }
                LieuCovoiturage lieuCovoiturage = new LieuCovoiturage(idLieu, nomLieu, adresseLieu, typeLieu, longitude, latitude, festival);
                lieuxCovoiturages.add(lieuCovoiturage);



            }
        }
        System.out.println();
    }
}
