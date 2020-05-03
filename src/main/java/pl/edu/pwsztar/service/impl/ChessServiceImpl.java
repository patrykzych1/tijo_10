package pl.edu.pwsztar.service.impl;

import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.FigureMoveDto;
import pl.edu.pwsztar.domain.enums.FigureType;
import pl.edu.pwsztar.service.ChessService;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class ChessServiceImpl implements ChessService {
    @Override
    public boolean checkMove(FigureMoveDto figureMoveDto) {
        FigureType figureType = figureMoveDto.getType();
        switch(figureType)
        {
            case BISHOP:
                return checkBishopMove(figureMoveDto);
            case KING: break;
            case PAWN: break;
            case ROCK: break;
            case QUEEN: break;
            case KNIGHT: break;
            default:
        }


       return false;

    }

     private boolean checkBishopMove(FigureMoveDto figureMoveDto) {
        String[] startPosition = figureMoveDto.getStart().split("_");
        String[] destinationPosition = figureMoveDto.getDestination().split("_");
        List<String> positions = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h"));

        int currentColumn = positions.indexOf(startPosition[0]);
        int currentRow = Integer.parseInt(startPosition[1]);
        int destinationColumn = positions.indexOf(destinationPosition[0]);
        int destinationRow = Integer.parseInt(destinationPosition[1]);

         // Nie można przejść z tego samego pola na to samo pole
        if (currentColumn == destinationColumn && currentRow == destinationRow) {
            return false;
        }

        return Math.abs(destinationColumn - currentColumn) == Math.abs(destinationRow - currentRow);
    }

}
