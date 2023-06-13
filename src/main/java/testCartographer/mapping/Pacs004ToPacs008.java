package testCartographer.mapping;

import com.cartographer.activity.ActivityType;
import com.cartographer.exception.CGException;
import com.cartographer.exception.CGExceptionFactory;
import com.cartographer.exception.Event;
import com.cartographer.xml.message.PACS008.*;

import javax.xml.datatype.DatatypeFactory;
import java.math.BigDecimal;

public class Pacs004ToPacs008 {
    private final Document pacs008;
    private final com.cartographer.xml.message.PACS004.Document pacs004;
    private final CGException mappingException;

    public Pacs004ToPacs008(com.cartographer.xml.message.PACS004.Document pacs004) {
        this.pacs008 = new Document();
        this.pacs004 = pacs004;
        this.mappingException = CGExceptionFactory.newInstance(ActivityType.MAPPING);
    }

    public Document map() {
        try {
            this.pacs008.setFIToFICstmrCdtTrf(new FIToFICustomerCreditTransferV11());
            this.pacs008.getFIToFICstmrCdtTrf().setGrpHdr(this.mapGroupHeader());
        } catch (Exception e) {
            this.mappingException.add(new Event(e));
        }
        return this.pacs008;
    }

    private GroupHeader96 mapGroupHeader() {
        GroupHeader96 grpHdr = new GroupHeader96();
        grpHdr.setMsgId(this.pacs004.getPmtRtr().getGrpHdr().getMsgId());
        grpHdr.setCreDtTm(DatatypeFactory.newDefaultInstance().newXMLGregorianCalendar("2023-01-01T20:30:30.345"));
        grpHdr.setNbOfTxs("1");
        grpHdr.setCtrlSum(BigDecimal.valueOf(1000.12));
        // GrpHdr.TtlIntrBkSttlmAmt
        ActiveCurrencyAndAmount amtCcy = new ActiveCurrencyAndAmount();
        amtCcy.setCcy("INR");
        amtCcy.setValue(BigDecimal.valueOf(30897.99));
        grpHdr.setTtlIntrBkSttlmAmt(amtCcy);
        // GrpHdr.IntrBkSttlmDt
        grpHdr.setIntrBkSttlmDt(this.pacs004.getPmtRtr().getGrpHdr().getIntrBkSttlmDt());
        // GrpHdr.SttlmInf
        SettlementInstruction11 sttlmInf = new SettlementInstruction11();
        sttlmInf.setSttlmMtd(SettlementMethod1Code.INDA);
        grpHdr.setSttlmInf(sttlmInf);
        return grpHdr;
    }
}
