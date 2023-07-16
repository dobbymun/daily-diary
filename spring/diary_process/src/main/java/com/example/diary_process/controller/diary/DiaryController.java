package com.example.diary_process.controller.diary;

import com.example.diary_process.controller.diary.form.DiaryForm;
import com.example.diary_process.entity.diary.Diary;
import com.example.diary_process.service.diary.DiaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("daily-diary/diary")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @PostMapping("/")
    public void create(@RequestBody DiaryForm diaryForm) {
        diaryService.create(
                diaryForm.getUuid(),
                diaryForm.getContent(),
                diaryForm.getEmotion(),
                diaryForm.getCreationDate(),
                diaryForm.getFile()
        );
    }

    @GetMapping("/")
    public List<Diary> list(@RequestParam("uuid") String uuid) {
        return diaryService.list(uuid);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        diaryService.delete(id);
    }

}
