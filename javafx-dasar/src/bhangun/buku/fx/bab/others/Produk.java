package bhangun.buku.fx.bab.others;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produk {
	
	private StringProperty nama;
    private IntegerProperty harga;
    private IntegerProperty tahun;
    
    public Produk(String fnama,Integer fharga,Integer ftahun){
    	nama = new SimpleStringProperty(fnama);
        harga = new SimpleIntegerProperty(fharga);
        tahun = new SimpleIntegerProperty(ftahun);
    }

	public void setNama(StringProperty nama) {
		this.nama = nama;
	}

	public void setHarga(IntegerProperty harga) {
		this.harga = harga;
	}

	public void setTahun(IntegerProperty tahun) {
		this.tahun = tahun;
	}

	public StringProperty getNama() {
		return nama;
	}

	public IntegerProperty getHarga() {
		return harga;
	}

	public IntegerProperty getTahun() {
		return tahun;
	}

}
