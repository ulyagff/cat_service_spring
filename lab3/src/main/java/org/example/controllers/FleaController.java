package org.example.controllers;

import entity.Flea;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.services.FleaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/flea")
public class FleaController {
    @Autowired
    FleaService fleaService;

    @Operation(summary = "Добавить блоху")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Блоха добавлена")
    )
    @PostMapping(path = "add/{name}/{catId}")
    public ResponseEntity<String> addFlea (@PathVariable @Parameter(description = "имя блохи") String name,
                                         @PathVariable @Parameter(description = "id блохи") int catId) {
        fleaService.addFlea(name, catId);
        return ResponseEntity.ok("Saved");
    }

    @Operation(summary = "Удалить блоху по id")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Блоха удалена")
    )
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteFlea (@PathVariable @Parameter(description = "id блохи") int id) {
        fleaService.deleteFlea(id);
        return ResponseEntity.ok("Delete");
    }

    @Operation(summary = "Получить блоху по id")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Блоха получена")
    )
    @GetMapping(path = "/getFlea/byId/{id}")
    public ResponseEntity<Flea> getFleaById (@PathVariable @Parameter(description = "id блохи") int id) {
        return ResponseEntity.ok(fleaService.getFleaById(id));
    }

    @Operation(summary = "Получить всех блох по id кота")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Блохи получены")
    )
    @GetMapping(path = "/getFlea/byCatId/{catId}")
    public ResponseEntity<List<Flea>> getFleaByCatId (@PathVariable @Parameter(description = "id кота") int catId) {
        return ResponseEntity.ok(fleaService.getAllByCatId(catId));
    }

    @Operation(summary = "Удалить всех блох")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Блохи удалены")
    )
    @DeleteMapping(path = "/deleteAll")
    public ResponseEntity<String> deleteAll() {
        fleaService.deleteAll();
        return ResponseEntity.ok("Dalete all");
    }

    @Operation(summary = "Получить всех блох")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Блохи получены")
    )
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Flea>> getAll() {
        return ResponseEntity.ok(fleaService.getAll());
    }
}
