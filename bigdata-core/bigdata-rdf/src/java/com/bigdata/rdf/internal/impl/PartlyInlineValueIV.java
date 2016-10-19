package com.bigdata.rdf.internal.impl;

import com.bigdata.rdf.internal.INonInlineExtensionCodes;
import com.bigdata.rdf.internal.IV;
import com.bigdata.rdf.internal.impl.literal.AbstractLiteralIV;
import com.bigdata.rdf.model.BigdataLiteral;
import com.bigdata.rdf.model.BigdataValue;

public class PartlyInlineValueIV<V extends BigdataValue, T> extends AbstractNonInlineExtensionIVWithDelegateIV<V, T> {

	private static final long serialVersionUID = -1216692077505448860L;

	public PartlyInlineValueIV(AbstractLiteralIV<BigdataLiteral, ?> delegate, IV<?, ?> extensionIV) {
		super(delegate.getVTE(), delegate, extensionIV);
	}

	@Override
	public IV<V, T> clone(boolean clearCache) {
		
		final PartlyInlineValueIV<V, T> tmp = new PartlyInlineValueIV<V, T>(
				getDelegate(), getExtensionIV());

		if (!clearCache) {

			tmp.setValue(getValueCache());

		}

		return tmp;
		
	}

	@Override
	public byte getExtensionByte() {
		
		return INonInlineExtensionCodes.ValueIV;
		
	}

}
