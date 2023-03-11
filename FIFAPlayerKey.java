class FIFAPlayerKey implements Keyed{
    private int jerseyNumber;
    private String country;

    public FIFAPlayerKey(int _jerseyNumber, String _country) {
        jerseyNumber = _jerseyNumber;
        country = _country;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int keyComp(Keyed other) {
        if(other instanceof FIFAPlayerKey) {
            return _keyComp((FIFAPlayerKey) other);
        }
        return -1;
    }
    private int _keyComp(FIFAPlayerKey other) {
        int comp1 = getCountry().compareTo(other.country);
        if(comp1 == 0) {
            if( getJerseyNumber() > other.getJerseyNumber() ) {
                return 1;
            }
            else if( getJerseyNumber() < other.getJerseyNumber() )
                return -1;

            else return 0;
        }
        return comp1;
    }

    @Override
    public String briefSummary() {
        String s = getJerseyNumber() + getCountry().substring(0,3);
        return s;
    }

    @Override
    public String toString() {
        return getCountry() + " " + getJerseyNumber();
    }
}

