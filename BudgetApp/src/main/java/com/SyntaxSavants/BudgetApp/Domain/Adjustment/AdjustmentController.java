package com.SyntaxSavants.BudgetApp.Domain.Adjustment;

import com.SyntaxSavants.BudgetApp.Domain.User.User;
import com.SyntaxSavants.BudgetApp.Repository.AdjustmentRepository;
import com.SyntaxSavants.BudgetApp.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class AdjustmentController {

    @Autowired
    private AdjustmentRepository adjustmentRepository;

    @Autowired
    private AuthenticationService authentication;

    @GetMapping("/adjustments")
    @CrossOrigin
    public ResponseEntity<List<Adjustment>> getAdjustments(@RequestHeader String auth) throws SQLException {
        Optional<User> userOptional = authentication.authenticateUser(auth);
        if (userOptional.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        User user = userOptional.get();

        //return new ResponseEntity<>(user.getAdjustments(), HttpStatus.OK);
        return null;
    }

    @PostMapping("/adjustments")
    @CrossOrigin
    public ResponseEntity<List<Adjustment>> createAdjustment(@RequestBody CreateAdjustmentRequest request) throws SQLException{
        Adjustment t = new Adjustment();
        t.setId(request.getId());
        t.setAmt(request.getAmt());
        t.setDate(request.getDate());
        t.setPlanned(request.isPlanned());
        t.setUser(request.getUser());

        return null;
    }

}
