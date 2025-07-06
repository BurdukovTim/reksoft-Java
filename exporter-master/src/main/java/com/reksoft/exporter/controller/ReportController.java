package com.reksoft.exporter.controller;

import com.reksoft.exporter.service.PlayerCsvReportService;
import com.reksoft.exporter.service.TeamCsvReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final PlayerCsvReportService reportService;
    private final TeamCsvReportService teamCsvReportService;
    private final Clock clock;


    @GetMapping
    public String getReportPage() {
        return "report";
    }

    @GetMapping("/player/download")
    public ResponseEntity<Resource> downloadPlayerReport() throws IOException {
        String timestamp = LocalDateTime.now(clock).format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = "player_report_%s.csv".formatted(timestamp);
        File reportFile = reportService.generateReport(System.getProperty("java.io.tmpdir") + File.separator + filename);

        FileSystemResource resource = new FileSystemResource(reportFile);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentLength(Files.size(reportFile.toPath()))
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(resource);
    }

    @GetMapping("/team/download")
    public ResponseEntity<Resource> downloadTeamReport() throws IOException {
        String timestamp = LocalDateTime.now(clock).format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = "team_report_%s.csv".formatted(timestamp);
        File reportFile = teamCsvReportService.generateReport(System.getProperty("java.io.tmpdir") + File.separator + filename);

        FileSystemResource resource = new FileSystemResource(reportFile);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentLength(Files.size(reportFile.toPath()))
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(resource);
    }

}
