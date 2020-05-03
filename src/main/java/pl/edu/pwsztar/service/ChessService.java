package pl.edu.pwsztar.service;

import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.FigureMoveDto;


public interface ChessService {
    boolean checkMove(FigureMoveDto figureMoveDto);
}
