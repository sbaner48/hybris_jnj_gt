<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="cartData" required="true" type="de.hybris.platform.commercefacades.order.data.CartData" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/desktop/product" %>
<%@ taglib prefix="grid" tagdir="/WEB-INF/tags/desktop/grid" %>



<script id="cartItemsTemplate" type="text/x-jquery-tmpl">
	<div class="headline"><spring:theme code="basket.page.title.yourItems"/></div>
	<div class="orderList">
	<table class="orderListTable deliveryCartItems">
		<thead>
			<tr>
				<th id="header2" colspan="2"><spring:theme code="text.productDetails" text="Product Details"/></th>
				<th id="header3"><spring:theme code="text.itemPrice" text="Item Price"/></th>
				<th id="header4"><spring:theme code="text.quantity" text="Quantity"/></th>
				<th id="header6"><spring:theme code="text.total" text="Total"/></th>
				<th id="header7">&nbsp;</th>
			</tr>
		</thead>

		<tbody>
			{{each data.entries}}
				{{tmpl($value) "#orderEntryTemplate"}}
			{{/each}}
		</thead>
	</table>
	</div>
</script>

<script id="orderEntryTemplate" type="text/x-jquery-tmpl">
<tr>
	<td class="thumb">
		<a href="{{= "<c:url value="/"/>"+product.url}}">
			{{each product.images}}
				{{if imageType=='PRIMARY' && format=='thumbnail'}}
					<img src={{= url}} alt={{= $item.name}} title={{= $item.name}}/>
				{{/if}}
			{{/each}}
		</a>
	</td>
	<td class="desc">
		<div class="name"><a href="{{= "<c:url value="/"/>"+product.url}}">{{= product.name}}</a></div>
						
						
		{{each product.baseOptions}}
			{{if selected && selected.url==$item.productUrl}}
				{{each selected.variantOptionQualifiers}}
					<div>{{= name}}: {{= value}}</div>
				{{/each}}
			{{/if}}
		{{/each}}


		{{if entries}}
			<div style="display:none" id="grid_{{= product.code}}" data-sub-entries="{{each entries}}{{= product.code}}:{{= quantity}},{{/each}}"> </div>
		{{/if}}

		{{if product.potentialProductPromotions }}
			<ul class="cart-promotions">
				{{each product.potentialProductPromotions}}
					{{each consumedEntries}}
						{{if orderEntryNumber==$item.entryNumber && adjustedUnitPrice > 0 }}
						 	  <li class="cart-promotions-potential"><span>{{= $item.description}}</span></li>
						{{/if}}
					{{/each}}
				{{/each}}
			</ul>
		{{/if}}
						
		{{if product.appliedProductPromotions }}
			<ul class="cart-promotions">
				{{each product.appliedProductPromotions}}
					{{each consumedEntries}}
						{{if orderEntryNumber==$item.entryNumber && adjustedUnitPrice > 0 }}
						 	 <li class="cart-promotions-applied"><span>{{= $item.description}}</span></li>
						{{/if}}
					{{/each}}
				{{/each}}
			</ul>
		{{/if}}
	</td>

	{{if product.multidimensional && (product.priceRange.minPrice.value != product.priceRange.maxPrice.value)}}
		<td class="priceRow">{{= product.priceRange.minPrice.formattedValue}} - {{= product.priceRange.maxPrice.formattedValue}}</td>
	{{else}}
		<td class="priceRow">{{= basePrice.formattedValue}}</td>
	{{/if}}
					
	<td class="priceRow"><spring:theme code="basket.page.quantity"/>: {{= quantity}}</td>
	<td class="priceRow">{{= totalPrice.formattedValue}}</td>
	<td headers="header7" class="multidimensional">
		{{if product.multidimensional}}
			<a href="#" id="QuantityProductToggle_{{= product.code}}" class="showQuantityProduct updateQuantityProduct-toggle">+</a> <!-- multidimensional test seems to be missing -->
		{{/if}}
	</td>
</tr>
<tr>
	<td colspan="7"><div id="ajaxGrid_{{= product.code}}" style="display: none"></div></td>
</tr>
</script>


<div id="ajaxCartItems"></div>
