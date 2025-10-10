package sistema.de.manutencao.industrial.module.piece.domain.service;

import sistema.de.manutencao.industrial.module.piece.application.dto.list.PieceListResponse;
import sistema.de.manutencao.industrial.module.piece.application.dto.register.RegisterPieceRequest;
import sistema.de.manutencao.industrial.module.piece.application.dto.register.RegisterPieceResponse;
import sistema.de.manutencao.industrial.module.piece.domain.PieceEntity;
import sistema.de.manutencao.industrial.module.piece.domain.exception.PieceNotUniqueException;
import sistema.de.manutencao.industrial.module.piece.domain.mapper.PieceMapper;
import sistema.de.manutencao.industrial.module.piece.domain.port.PieceRepository;

import java.util.List;

public class PieceService {

    private final PieceRepository pieceRepository;
    private final PieceMapper pieceMapper;

    public PieceService(PieceRepository pieceRepository, PieceMapper pieceMapper) {
        this.pieceRepository = pieceRepository;
        this.pieceMapper = pieceMapper;
    }

    public RegisterPieceResponse register(RegisterPieceRequest registerPieceRequest) {
        PieceEntity piece = new PieceEntity(registerPieceRequest.name(), registerPieceRequest.quantity());

        if(!pieceRepository.isUnique(piece)){
            throw new PieceNotUniqueException();
        }

        pieceRepository.save(piece);

        return pieceMapper.toRegisterResponse(piece);

    }

    public List<PieceListResponse> getAll() {
        return pieceRepository.getAll().stream().map(pieceMapper::toListResponse).toList();
    }
}
