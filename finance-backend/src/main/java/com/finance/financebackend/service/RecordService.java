package com.finance.financebackend.service;
import com.finance.financebackend.entity.Record;
import com.finance.financebackend.dto.RecordDto;
import com.finance.financebackend.repository.RecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecordService {

    private final RecordRepository repo;

    public RecordService(RecordRepository repo) {
        this.repo = repo;
    }

    public Record create(RecordDto dto) {

        Record record = new Record();

        record.setAmount(dto.getAmount());
        record.setType(dto.getType());
        record.setCategory(dto.getCategory());
        record.setDate(dto.getDate());
        record.setNote(dto.getNote());

        return repo.save(record);
    }

    public List<Record> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Record> getByType(String type) {
        return repo.findByType(type);
    }

    public List<Record> getByCategory(String category) {
        return repo.findByCategory(category);
    }
}