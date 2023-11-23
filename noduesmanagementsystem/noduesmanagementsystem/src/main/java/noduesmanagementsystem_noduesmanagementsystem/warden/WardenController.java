package noduesmanagementsystem_noduesmanagementsystem.warden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wardens")
public class WardenController {

    private final WardenService wardenService;

    public WardenController(WardenService wardenService) {
        this.wardenService = wardenService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<Warden> getWardenByEmail(@PathVariable("email") String email) {
        Warden warden = wardenService.getWardenByEmail(email);
        if (warden == null) {
            throw new ResourceNotFoundException("Warden not found with email: " + email);
        }
        return ResponseEntity.ok(warden);
    }

    @PostMapping
    public ResponseEntity<Void> createWarden(@RequestBody Warden warden) {
        wardenService.saveWarden(warden);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
