package dev.easbarba.apito_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.easbarba.apito_backend.domain.Referee;
import dev.easbarba.apito_backend.repository.RefereeRepository;

@Service
public class RefereeService {
    @Autowired
    private RefereeRepository refereeRepository;

    public ResponseEntity<Referee> save(Referee referee) {
        Referee ref = refereeRepository.save(referee);
        return ResponseEntity.status(HttpStatus.CREATED).body(ref);
    }

    public ResponseEntity<Iterable<Referee>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(refereeRepository.findAll());
    }

    public ResponseEntity<Optional<Referee>> findById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(refereeRepository.findById(id));
    }

    public ResponseEntity<?> update(Referee referee, Long id) {
        var ref = refereeRepository.findById(id);

        if (!ref.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Referee not found.");
        }

        ref.get().setName(referee.getName());
        ref.get().setState(referee.getState());

        return ResponseEntity.status(HttpStatus.OK).body(refereeRepository.save(ref.get()));
    }

    public ResponseEntity<?> delete(Long id) {
        var ref = refereeRepository.findById(id).orElse(null);
        refereeRepository.delete(ref);

        return ResponseEntity.status(HttpStatus.OK).body("Referee deleted successfully.");
    }
}
