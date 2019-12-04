package edu.ssafy.boot.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.ssafy.boot.dto.BoolResult;
import edu.ssafy.boot.dto.Member;
import edu.ssafy.boot.service.MemService;
@RestController // request responsebody 안 해줘도 돼!
@RequestMapping("/api")
public class RestMemberController {
    @Autowired
    @Qualifier("MemServiceImpl")
    MemService ser;
    // 클라이언트에서 멤버 정보 주면 서비스로 가서
    // 서비스에서 레포지터리 가서 저장하는 것 까지 해보겠다.
    @PostMapping("/meminsert") /* /member/memregpage */
    public ResponseEntity<String> insert(Member mem) {
        ResponseEntity<String> re = null;
        try {
            ser.insert(mem.getId(), mem.getPw(), mem.getName(), mem.getEmail());
            re = new ResponseEntity<String>("잘 들어갔어", HttpStatus.OK);
        } catch (Exception e) {
            re = new ResponseEntity<String>("잘 안 들어갔어", HttpStatus.NOT_MODIFIED);
        }
        return re;
    }
    @PutMapping("/memupdate")
    public ResponseEntity<BoolResult> update(Member mem) {
        ResponseEntity<BoolResult> re = null;
        try {
            ser.update(mem.getId(), mem.getPw(), mem.getName(), mem.getEmail());
            re = new ResponseEntity<BoolResult>(new BoolResult("update", true, "sucess"), HttpStatus.OK);
        } catch (Exception e) {
            re = new ResponseEntity<BoolResult>(new BoolResult("update", false, "fail"), HttpStatus.NOT_MODIFIED);
        }
        return re;
    
    }
    @DeleteMapping("/memdelete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        ResponseEntity<String> re = null;
        try {
            ser.delete(id);
            re = new ResponseEntity<String>("잘 삭제됐어", HttpStatus.OK);
        } catch (Exception e) {
            re = new ResponseEntity<String>("삭제 안 됐어", HttpStatus.NOT_MODIFIED);
        }
        return re;
        
    }
    @GetMapping("/memselectone/{id}")
    public ResponseEntity<Member> selectOne(@PathVariable String id) {
        ResponseEntity<Member> re = null;     
        try {
            Member selectOne = ser.selectOne(id);
            re = new ResponseEntity<Member>(selectOne, HttpStatus.OK);
        } catch (Exception e) {
            re = new ResponseEntity("조회 실패했어요", HttpStatus.NO_CONTENT);
        }
        return re;
    }
    @GetMapping("/memselectlist")
    public ResponseEntity<List<Member>> selectList() {
        ResponseEntity<List<Member>> re = null;     
        try {
            List<Member> list = ser.selectList();
            re = new ResponseEntity<List<Member>>(list, HttpStatus.OK);
        } catch (Exception e) {
            re = new ResponseEntity("조회 실패했어요", HttpStatus.NO_CONTENT);
        }
        return re;
        
        
    }
}
