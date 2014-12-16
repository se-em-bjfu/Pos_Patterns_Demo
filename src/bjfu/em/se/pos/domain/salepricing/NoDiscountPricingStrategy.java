package bjfu.em.se.pos.domain.salepricing;

import bjfu.em.se.pos.domain.Sale;

/**
 * 无折扣 定价策略实现类
 * @author Roy
 *
 */
public class NoDiscountPricingStrategy implements ISalePricingStrategy {

	@Override
	public int calculate(Sale s) {
		return s.getPreDiscountTotal();
	}

	@Override
	public String getName() {
		return "无折扣";
	}

	@Override
	public String getDescription() {
		return "无折扣";
	}

}
