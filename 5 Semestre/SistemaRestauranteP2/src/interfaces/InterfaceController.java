package interfaces;

import java.util.List;

public abstract class InterfaceController {
    protected InterfaceDTO interfaceDTO;
    
    public abstract boolean insert(InterfaceDTO dto);
    public abstract boolean update(InterfaceDTO dto);
    public abstract boolean delete(InterfaceDTO dto);
    public abstract List<InterfaceDTO> list();
    public abstract InterfaceDTO getById(Integer id);

    //public abstract Object[][] listTable();

    public Object[] getTableData(){
        return interfaceDTO.getTableData();
    }
    
    public String[] getTableHeader(){
        return interfaceDTO.getTableHeader();
    }

    public InterfaceDTO getInterfaceDTO() {
        return interfaceDTO;
    }

    public void setInterfaceDTO(InterfaceDTO interfaceDTO) {
        this.interfaceDTO = interfaceDTO;
    }
}
