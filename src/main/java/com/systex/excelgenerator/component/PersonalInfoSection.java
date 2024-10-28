package com.systex.excelgenerator.component;

import com.systex.excelgenerator.model.Candidate;
import com.systex.excelgenerator.component.Section;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.text.SimpleDateFormat;

public class PersonalInfoSection extends Section {

    private Candidate candidate;

    public PersonalInfoSection(Candidate candidate) {
        super("Personal Information");
        this.candidate = candidate;
    }

    @Override
    public int populate(XSSFSheet sheet, int rowNum) {
        addHeader(sheet, rowNum);
        rowNum++;

        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue("Name");
        row.createCell(1).setCellValue(candidate.getName());

        row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue("Gender");
        row.createCell(1).setCellValue(candidate.getGender());

        row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue("Birthday");
        row.createCell(1).setCellValue(SimpleDateFormat.getDateInstance().format(candidate.getBirthday()));

        row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue("Phone");
        row.createCell(1).setCellValue(candidate.getPhone());

        row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue("Email");
        row.createCell(1).setCellValue(candidate.getEmail());

        row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue("Address");
        row.createCell(1).setCellValue(candidate.getAddress().toString());

        return rowNum;
    }
}