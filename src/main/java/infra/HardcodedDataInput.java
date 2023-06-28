package infra;

import application.DataInput;
import domain.Data;
import domain.Order;

import java.util.ArrayList;
import java.util.List;

public class HardcodedDataInput implements DataInput {
    @Override
    public int configBufferLength() {
        return 3;
    }

    @Override
    public List<Data> sendOrders() {
        return new ArrayList<>();
    }

    public List<Data> retrieveAndTranslateData()
    {
        List<Data> returnedData = new ArrayList<>();

        List<String> rowDataList= new ArrayList<>();
        rowDataList.add("HOLA");
        rowDataList.add("segundo");
        rowDataList.add("LEE");
        rowDataList.add("DESHACER");
        rowDataList.add("LEE");
        rowDataList.add("BLOQUEA");
        rowDataList.add("QUE");
        rowDataList.add("YA");
        rowDataList.add("DESHACER");
        rowDataList.add("LEE");

        for(String rowOrder : rowDataList)
        {
            returnedData.add(translate(rowOrder));
        }
        return returnedData;
    }

    private Data translate(String rowOrder)
    {
        if("LEE".equals(rowOrder))
        {
            return new Data(Order.READ_LAST, "");
        }
       else if("BLOQUEA".equals(rowOrder))
        {
            return new Data(Order.BLOCK, "");
        }
        else if("DESBLOQUEA".equals(rowOrder))
        {
            return new Data(Order.UNBLOCK, "");
        }
        else if("DESHACER".equals(rowOrder))
        {
            return new Data(Order.CTRZ, "");
        }
        else return new Data(Order.SAVE, rowOrder);
    }
}
