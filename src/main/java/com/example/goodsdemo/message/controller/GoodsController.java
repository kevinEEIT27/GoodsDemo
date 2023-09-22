package com.example.goodsdemo.message.controller;

import com.example.goodsdemo.message.dao.GoodsRepository;
import com.example.goodsdemo.message.entity.Goods;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
@Tag(
	name = "GoodsController",
	description = "商品API接口",
	externalDocs = @ExternalDocumentation(
		description = "須帶入Authorization : bearer Token 於Header，才能與API溝通"))
public class GoodsController {

	@Autowired
	GoodsRepository goodsRepository;

	@Operation(
		summary = "取得所有商品資料",
		description = "只需要帶入Token",
		parameters = {
			@Parameter(name = "Authorization", in = ParameterIn.HEADER, description = "須帶入Authorization : bearer Token 於Header，才能與API溝通",
				required = true, example = "bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySUQiOjEsInVzZXJuYW1lIjoiNTU2ODgiLCJhY2NvdW50IjoiNTU2ODgiLCJtb2JpbGUiOiI1NTY4OCIsImV4cCI6MTY5NTMxMDAyMywiaXNzIjoiV0FOTkFHVUFHVUEifQ.v3jt5HLFYbs3huoAVYmlHUNxfxD0E7KzPNbMtwaExLah36je-lTyCEa4b2a79uXCKlep80o_7whCZSCytDV03Q")
		},
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "成功",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(
						title = "goos物件",
						description = "回傳商品陣列",
						anyOf = {Goods.class})
				)
			)
		}
	)
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/v1/goods")
	public List<Goods> getAll() {
		return goodsRepository.findAll();
	}

	@Operation(
		summary = "使用Id查詢商品資料",
		description = "以商品ID查詢單一商品資料，並回傳商品物件",
		parameters = {
			@Parameter(name = "id", description = "商品ID", required = true, example = "1"),
			@Parameter(name = "Authorization", in = ParameterIn.HEADER, description = "須帶入Authorization : bearer Token 於Header，才能與API溝通",
				required = true, example = "bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySUQiOjEsInVzZXJuYW1lIjoiNTU2ODgiLCJhY2NvdW50IjoiNTU2ODgiLCJtb2JpbGUiOiI1NTY4OCIsImV4cCI6MTY5NTMxMDAyMywiaXNzIjoiV0FOTkFHVUFHVUEifQ.v3jt5HLFYbs3huoAVYmlHUNxfxD0E7KzPNbMtwaExLah36je-lTyCEa4b2a79uXCKlep80o_7whCZSCytDV03Q")
		},
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "成功",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(
						title = "商品物件",
						description = "回傳商品物件，Goods",
						anyOf = {Goods.class})
				)
			),
		}
	)
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "v1/goods/{id}")
	public Goods getOne(@PathVariable(value="id") Long id) {
		return goodsRepository.findById(id).get();
	}

	@Operation(
		summary = "建立商品",
		description = "設定商品名稱建立商品，成功及回傳商品物件",
		parameters = {
			@Parameter(name = "Authorization", in = ParameterIn.HEADER, description = "須帶入Authorization : bearer Token 於Header，才能與API溝通",
				required = true, example = "bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySUQiOjEsInVzZXJuYW1lIjoiNTU2ODgiLCJhY2NvdW50IjoiNTU2ODgiLCJtb2JpbGUiOiI1NTY4OCIsImV4cCI6MTY5NTMxMDAyMywiaXNzIjoiV0FOTkFHVUFHVUEifQ.v3jt5HLFYbs3huoAVYmlHUNxfxD0E7KzPNbMtwaExLah36je-lTyCEa4b2a79uXCKlep80o_7whCZSCytDV03Q")
		},
		requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "商品物件",
			required = true,
			content = {
				@Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Goods.class)
				)
			}
		),
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "成功",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(
						title = "商品物件",
						description = "回傳商品物件，Goods",
						anyOf = {Goods.class})
				)
			),
		}
	)
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/v1/goods/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Goods add(@RequestBody Goods goods) {

		return goodsRepository.save(goods);
	}

	@Operation(
		summary = "更新商品",
		description = "需指定ID，並傳入更新後的商品物件，成功及回傳商品物件",
		parameters = {
			@Parameter(name = "id", description = "商品ID", required = true, example = "1"),
			@Parameter(name = "Authorization", in = ParameterIn.HEADER, description = "須帶入Authorization : bearer Token 於Header，才能與API溝通",
				required = true, example = "bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySUQiOjEsInVzZXJuYW1lIjoiNTU2ODgiLCJhY2NvdW50IjoiNTU2ODgiLCJtb2JpbGUiOiI1NTY4OCIsImV4cCI6MTY5NTMxMDAyMywiaXNzIjoiV0FOTkFHVUFHVUEifQ.v3jt5HLFYbs3huoAVYmlHUNxfxD0E7KzPNbMtwaExLah36je-lTyCEa4b2a79uXCKlep80o_7whCZSCytDV03Q")
		},
		requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "商品物件",
			required = true,
			content = {
				@Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Goods.class)
				)
			}
		),
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "成功",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(
						title = "商品物件",
						description = "回傳商品物件，Goods",
						anyOf = {Goods.class})
				)
			),
		}
	)
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("v1/goods/{id}")
	public Goods update(@RequestBody Goods goods, @PathVariable(value = "id") Long id) {

		Goods good = goodsRepository.findById(id).get();
		good.setName(goods.getName());
		return goodsRepository.save(good);
	}


	@Operation(
		summary = "使用Id刪除商品資料",
		description = "以商品ID刪除單一商品資料",
		parameters = {
			@Parameter(name = "id", description = "商品ID", required = true, example = "1"),
			@Parameter(name = "Authorization", in = ParameterIn.HEADER, description = "須帶入Authorization : bearer Token 於Header，才能與API溝通",
				required = true, example = "bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySUQiOjEsInVzZXJuYW1lIjoiNTU2ODgiLCJhY2NvdW50IjoiNTU2ODgiLCJtb2JpbGUiOiI1NTY4OCIsImV4cCI6MTY5NTMxMDAyMywiaXNzIjoiV0FOTkFHVUFHVUEifQ.v3jt5HLFYbs3huoAVYmlHUNxfxD0E7KzPNbMtwaExLah36je-lTyCEa4b2a79uXCKlep80o_7whCZSCytDV03Q")
		},
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "成功"
			),
		}
	)
	@DeleteMapping(value = "/v1/goods/{id}")
	public ResponseEntity<Map<String, Object>> deleteGood(@PathVariable(value = "id") Long id) {

		Goods good = goodsRepository.findById(id).get();

		Map<String, Object> response;
		if (good.getId() != null) {

			goodsRepository.delete(good);
			response = Collections.singletonMap("success", true);
		} else {
			response = Collections.singletonMap("success", false);
		}
		return ResponseEntity.ok(response);
	}

}
