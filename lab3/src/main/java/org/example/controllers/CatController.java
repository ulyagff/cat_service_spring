package org.example.controllers;

import entity.Cat;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path="/cat")
public class CatController {
    @Autowired
    CatService catService;

    @Operation(summary = "Добавление кота")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Кот добавлен")
    )
    @PostMapping (path = "/add/{name}/{birthday}/{breed}/{color}/{ownerId}/{tailLength}")
    public ResponseEntity<String> addCat (@PathVariable @Parameter(description = "имя кота") String name,
                                        @PathVariable @Parameter(description = "дата рождения кота") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthday,
                                        @PathVariable @Parameter(description = "порода кота") String breed,
                                        @PathVariable @Parameter(description = "цвет кота, доступны white, black, gray, multicolor") String color,
                                        @PathVariable @Parameter(description = "id владельца") int ownerId,
                                        @PathVariable @Parameter(description = "длина хвоста") int tailLength
    ) {
        catService.addCat(name, birthday, breed, color, ownerId, tailLength);
        return ResponseEntity.ok("Saved");
    }

    @Operation(summary = "Удаление кота")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Кот удален")
    )
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteCat (@PathVariable @Parameter(description = "id кота") int id) {
        catService.deleteCat(id);
        return ResponseEntity.ok("Delete");
    }

    @Operation(summary = "Получить кота по id")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Кот получен")
    )
    @GetMapping(path = "/getCat/byId/{id}")
    public ResponseEntity<Cat> getCatById (@PathVariable @Parameter(description = "id кота") int id) {
        return ResponseEntity.ok(catService.getCatById(id));
    }

    @Operation(summary = "Получить котов по имени")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Коты получены")
    )
    @GetMapping(path = "/getCat/byName/{name}")
    public ResponseEntity<List<Cat>> getCatByName (@PathVariable @Parameter(description = "имя кота") String name) {
        return ResponseEntity.ok(catService.getAllByName(name));
    }

    @Operation(summary = "Получить котов по дате рождения")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Коты получены")
    )
    @GetMapping(path = "/getCat/byBirthday/{birthday}")
    public ResponseEntity<List<Cat>> getCatByBirthday (@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") @Parameter(description = "дата рождения кота")
                                                      LocalDate birthday) {
        return ResponseEntity.ok(catService.getAllByBirthday(birthday));
    }

    @Operation(summary = "Получить котов по породе")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Коты получены")
    )
    @GetMapping(path = "/getCat/byBreed/{breed}")
    public ResponseEntity<List<Cat>> getCatByBreed (@PathVariable @Parameter(description = "порода кота") String breed) {
        return ResponseEntity.ok(catService.getAllByBreed(breed));
    }

    @Operation(summary = "Получить котов по цвету")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Коты получены")
    )
    @GetMapping(path = "/getCat/byColor/{color}")
    public ResponseEntity<List<Cat>> getCatByColor (@PathVariable @Parameter(description = "цвет кота") String color) {
        return ResponseEntity.ok(catService.getAllByColor(color));
    }

    @Operation(summary = "Получить котов по id владельца")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Коты получены")
    )
    @GetMapping(path = "/getCat/byOwnerId/{ownerId}")
    public ResponseEntity<List<Cat>> getCatByOwnerId (@PathVariable @Parameter(description = "id владельца кота") int ownerId) {
        return ResponseEntity.ok(catService.getAllByOwnerId(ownerId));
    }

    @Operation(summary = "удалить всех котов")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Коты удалены")
    )
    @DeleteMapping(path = "/deleteAll")
    public ResponseEntity<String> deleteAll() {
        catService.deleteAll();
        return ResponseEntity.ok("Delete");
    }

    @Operation(summary = "Получить всех котов")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Коты получены")
    )
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Cat>> getAll () {
        return ResponseEntity.ok(catService.getAll());
    }
}
