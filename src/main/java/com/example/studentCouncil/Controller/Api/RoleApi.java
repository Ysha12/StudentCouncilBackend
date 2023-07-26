package com.example.studentCouncil.Controller.Api;
import com.example.studentCouncil.Dto.RoleReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/role")
public interface RoleApi {
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")

    public ResponseEntity addRole(@RequestBody RoleReqDto roleReqDto );

    @RequestMapping(value = "/getRoles", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getRoles(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getRoleById(@PathVariable("id") Integer id);

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity editRole(@PathVariable("id") Integer id, @RequestBody RoleReqDto roleReqDto);

    @RequestMapping(value = "/deleteRole/{ID}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteRole(@PathVariable("roleId") Integer roleId);
}
