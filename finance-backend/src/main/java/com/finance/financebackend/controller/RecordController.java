package com.finance.financebackend.controller;
import com.finance.financebackend.service.RecordService;
import com.finance.financebackend.dto.RecordDto;
import com.finance.financebackend.entity.Record;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Record create(@Valid @RequestBody RecordDto dto) {
        return service.create(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping
    public List<Record> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }

    @GetMapping("/type/{type}")
    public List<Record> getByType(@PathVariable String type) {
        return service.getByType(type);
    }

    @GetMapping("/category/{category}")
    public List<Record> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }
}