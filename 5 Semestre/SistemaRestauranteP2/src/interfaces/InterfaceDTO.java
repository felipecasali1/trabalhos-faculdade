package interfaces;

import java.util.LinkedList;
import java.util.List;

public abstract class InterfaceDTO {
//    public String id;
//    public abstract InterfaceDTO buildDTO(InterfaceEntity e);
//    public abstract InterfaceEntity buildEntity();

    public abstract String[] getTableHeader();
    public abstract Object[] getTableData();
   
//    public List<InterfaceDTO> buildListDTO(List<InterfaceEntity> listEntity){
//       List<InterfaceDTO> listDTO = new LinkedList<>();
//       
//        for (InterfaceEntity entity : listEntity) {
//            listDTO.add(this.buildDTO(entity));
//        }
//        
//        return listDTO;
//    }
}
