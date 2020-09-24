export default {
  data() {
    return {
      page: 1,
      maxpages: 1,
      items_per_pages: 12,
    };
  },
  methods: {
    next() {
      if (this.page < this.maxpages) {
        this.page = this.page + 1;
      }
    },
    previous() {
      if (this.page > 1) {
        this.page = this.page - 1;
      }
    },
    first() {
      this.page = 1;
    },
    last() {
      this.page = this.maxpages;
    },
    getPage(dataset) {
      this.maxpages = dataset.length / this.items_per_pages;
      if (this.maxpages < 1) {
        this.maxpages = 1;
      }
      let min = this.page * this.items_per_pages - this.items_per_pages;
      let max = this.page * this.items_per_pages;
      // return this.users;
      return dataset.slice(min, max);
    },
  },
};
