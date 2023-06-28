package domain;

import java.util.List;

public class DataStorer {
    private int length;
    private List<StoredValue> storedValues;

    private String valueInUse;
    private ReturnedState state;

    public DataStorer(int length) {
        this.length = length;
    }

    public ReturnedState getState() {
        return state;
    }

    public boolean isBlocked(){
        return this.storedValues.get(this.length - 1).isBlocked();
    }

    public void addValue(String myValue)
    {
       this.storedValues.add(new StoredValue(myValue));

       if(this.storedValues.size() > this.length) {
           for(int i = 0; i < this.length; i++)
           {
               if(!this.storedValues.get(i).isBlocked())
               {
                   this.storedValues.remove(0);
                   this.state = ReturnedState.OK;
                   return;
               }
           }
       }
       stateOk();
    }

    public void setValueInUse()
    {
        this.storedValues.get(lastIndexOfStoredValues()).getValue();
    }

    public String getValueInUse(){
        return this.storedValues.get(this.lastIndexOfStoredValues()).getValue();
    }


    public void removeValue()
    {
        if(this.storedValues.isEmpty())
        {
            this.state = ReturnedState.BUFFER_LENGHT_IS_O;
        }
        else if(this.storedValues.get(lastIndexOfStoredValues()).isBlocked())
        {
            this.state = ReturnedState.VALUE_BLOCKED_ERROR;
        }
        else
        {
            this.storedValues.remove(lastIndexOfStoredValues());
            setValueInUse();
            stateOk();
        }
    }

    private void stateOk()
    {
        this.state = ReturnedState.OK;
    }

    private int lastIndexOfStoredValues()
    {
        return this.storedValues.size()-1;
    }


}
