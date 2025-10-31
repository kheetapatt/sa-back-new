package ku.cs.food_production.service;

import ku.cs.food_production.dto.ProductionOrderDto;
import ku.cs.food_production.dto.ProductionOrderRecordDto;
import ku.cs.food_production.dto.UpdateStatusDto;
import ku.cs.food_production.entity.*;
import ku.cs.food_production.repository.ProductRepo;
import ku.cs.food_production.repository.ProductionOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductionOrderService {
    private ProductionOrderRepo repo;
    private ProductRepo productRepo;
    private MaterialRequestService materialRequestService;

    @Autowired
    public ProductionOrderService(ProductionOrderRepo repo, ProductRepo productRepo, MaterialRequestService materialRequestService) {
        this.repo = repo;
        this.productRepo = productRepo;
        this.materialRequestService = materialRequestService;
    }

    public ProductionOrder getById(int id) {
        return repo.findById(id).get();
    }

    public List<ProductionOrderDto> getAll() {
        List<ProductionOrder> orders = repo.findAll();
        List<ProductionOrderDto> dtos = new ArrayList<>();
        for (ProductionOrder order : orders) {
            ProductionOrderDto dto = new ProductionOrderDto();
            dto.setProductionOrderId(order.getId());
            dto.setProductId(order.getProduct().getId());
            dto.setProductName(order.getProduct().getName());
            dto.setQty(order.getQty());
            dto.setUnit(order.getProduct().getUnit());
            dto.setCreationDate(order.getCreationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm")));
            if (order.getStartDate() != null) {
                dto.setStartDate(order.getStartDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm")));
            } else {
                dto.setStartDate("-");
            }
            if (order.getEndDate() != null) {
                dto.setEndDate(order.getEndDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm")));
            } else {
                dto.setStartDate("-");
            }
            dto.setStatus(order.getStatus().getDescription());
            dtos.add(dto);
        }
        return dtos;
    }

    public ProductionOrder add(ProductionOrderRecordDto record) {
        ProductionOrder order = new ProductionOrder();
        LocalDateTime now = LocalDateTime.now();
        Product product = productRepo.getOne(record.getProductId());
        order.setProduct(product);

        ProductionOrderNumberGen gen = new ProductionOrderNumberGen(product.getCode(), now, getLastCreatedAt(now.toLocalDate(), product).getOrderNumber());
        order.setOrderNumber(gen.getProductionOrderNumber());
        order.setQty(record.getQty());
        order.setCreationDate(LocalDateTime.now());
        order.setStatus(ProductionOrderStatus.WAIT_FOR_ALLOCATION);
        List<MaterialRequest> materialRequests = new ArrayList<>();
        materialRequests.add(materialRequestService.calculateMaterialRequest(product.getRecipe(), record.getQty()));
        order.setMaterialRequests(materialRequests);
        return repo.save(order);
    }

    public ProductionOrder updateStatus(UpdateStatusDto updateStatusDto) {
        ProductionOrder productionOrder = getById(updateStatusDto.getPoId());
        ProductionOrderStatus selectedStatus = productionOrder.getStatus();
        for (ProductionOrderStatus status : ProductionOrderStatus.values()) {
            if (updateStatusDto.getNewStatus().equals(status.getDescription())) {
                selectedStatus = status;
                break;
            }
        }
        productionOrder.setStatus(selectedStatus);
        return repo.save(productionOrder);
    }

    public ProductionOrder getLastCreatedAt(LocalDate createdAt, Product product) {
        List<ProductionOrder> pos = repo.findAllByCreatedAt(createdAt);
        List<ProductionOrder> pos1 = pos.stream()
                .filter(lot -> lot.getProduct().getId() == product.getId())
                .collect(Collectors.toList());
        List<ProductionOrder> sortedProductionOrders = pos1.stream()
                .sorted(Comparator.comparing(ProductionOrder::getOrderNumber).reversed())
                .collect(Collectors.toList());
        return sortedProductionOrders.get(0);
    }
}
